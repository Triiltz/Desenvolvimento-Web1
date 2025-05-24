package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

@WebServlet("/converter")
public class Converter extends HttpServlet {
    private static final double MILHAS_PARA_METROS = 1609.34;
    private static final double PES_PARA_METROS = 0.3048;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String lang = request.getParameter("lang");
        if (lang != null) {
            session.setAttribute("userLang", lang); 
        } else {
            lang = (String) session.getAttribute("userLang");
            if (lang == null) {
                lang = "pt-BR";
            }
        }
        
        Locale locale = "en".equals(lang) ? Locale.ENGLISH : Locale.forLanguageTag("pt-BR");
        request.setAttribute("locale", locale);
        
        String valorStr = request.getParameter("valor");
        String conversao = request.getParameter("conversao");
        
        if (valorStr == null || valorStr.trim().isEmpty() || conversao == null) {
            request.setAttribute("errorType", "missing_params");
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
            return;
        }

        try {
            double valor = Double.parseDouble(valorStr.replace(",", "."));
            NumberFormat nf = NumberFormat.getNumberInstance(locale);
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);
            
            double resultado = calcularConversao(valor, conversao);
            
            request.setAttribute("valorFormatado", nf.format(valor));
            request.setAttribute("resultadoFormatado", nf.format(resultado));
            request.setAttribute("conversao", conversao);
            request.setAttribute("lang", lang);
            
            request.getRequestDispatcher("/resultado.jsp").forward(request, response);
            
        } catch (NumberFormatException e) {
            request.setAttribute("errorType", "invalid_number");
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        } catch (IllegalArgumentException e) {
            request.setAttribute("errorType", "invalid_conversion");
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }

    private double calcularConversao(double valor, String conversao) {
        switch (conversao) {
            case "mi_m":
                return valor * MILHAS_PARA_METROS;
            case "m_mi":
                return valor / MILHAS_PARA_METROS;
            case "ft_m":
                return valor * PES_PARA_METROS;
            case "m_ft":
                return valor / PES_PARA_METROS;
            default:
                throw new IllegalArgumentException("Tipo de conversão inválido");
        }
    }
}