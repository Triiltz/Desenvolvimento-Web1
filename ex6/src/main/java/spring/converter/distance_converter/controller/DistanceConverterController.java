package spring.converter.distance_converter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

@Controller
public class DistanceConverterController {

    private static final double MILES_TO_METERS_FACTOR = 1609.34;
    private static final double FEET_TO_METERS_FACTOR = 0.3048;

    @GetMapping("/")
    public String showForm(Model model) {
        return "index";
    }

    @GetMapping("/converter")
    public String handleGetConversion(@RequestParam(required = false) String valor,
                                      @RequestParam(required = false) String conversao,
                                      Model model, Locale locale, RedirectAttributes redirectAttributes) {
        return processConversion(valor, conversao, model, locale, redirectAttributes);
    }

    @PostMapping("/converter")
    public String handlePostConversion(@RequestParam(required = false) String valor,
                                       @RequestParam(required = false) String conversao,
                                       Model model, Locale locale, RedirectAttributes redirectAttributes) {
        return processConversion(valor, conversao, model, locale, redirectAttributes);
    }

    private String processConversion(String valorStr, String conversao, Model model, Locale locale, RedirectAttributes redirectAttributes) {
        if (valorStr == null || valorStr.trim().isEmpty() || conversao == null || conversao.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("errorType", "missing_params");
            String currentLang = locale.getLanguage().equalsIgnoreCase("pt") ? "pt-BR" : "en";
            redirectAttributes.addAttribute("lang", currentLang);
            return "redirect:/erro";
        }

        try {
            double valorOriginal = Double.parseDouble(valorStr.replace(",", "."));
            double resultado = calcularConversao(valorOriginal, conversao);

            NumberFormat nf = NumberFormat.getNumberInstance(locale);
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);

            model.addAttribute("valorOriginal", valorOriginal);
            model.addAttribute("valorFormatado", nf.format(valorOriginal));
            model.addAttribute("resultadoFormatado", nf.format(resultado));
            model.addAttribute("conversao", conversao);

            return "resultado";

        } catch (NumberFormatException e) {
            redirectAttributes.addFlashAttribute("errorType", "invalid_number");
            String currentLang = locale.getLanguage().equalsIgnoreCase("pt") ? "pt-BR" : "en";
            redirectAttributes.addAttribute("lang", currentLang);
            return "redirect:/erro";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorType", "invalid_conversion");
            String currentLang = locale.getLanguage().equalsIgnoreCase("pt") ? "pt-BR" : "en";
            redirectAttributes.addAttribute("lang", currentLang);
            return "redirect:/erro";
        }
    }

    @GetMapping("/erro")
    public String showErrorPage(Model model, @RequestParam(name = "lang", required = false) String langParam, Locale locale) {
        if (!model.containsAttribute("errorType")) {
            model.addAttribute("errorType", "generic");
        }
        return "erro";
    }

    private double calcularConversao(double valor, String conversao) {
        return switch (Objects.requireNonNull(conversao)) {
            case "mi_m" -> valor * MILES_TO_METERS_FACTOR;
            case "m_mi" -> valor / MILES_TO_METERS_FACTOR;
            case "ft_m" -> valor * FEET_TO_METERS_FACTOR;
            case "m_ft" -> valor / FEET_TO_METERS_FACTOR;
            default -> throw new IllegalArgumentException("Tipo de conversão inválido");
        };
    }
}