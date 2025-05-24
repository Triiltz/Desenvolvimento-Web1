package servlet;
import java.io.IOException;
import java.net.URLEncoder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/converter")
public class Converter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        requestHandler(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        requestHandler(request, response);
    }
    
    private void requestHandler(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String numeroStr = request.getParameter("valor");
        String unidade = request.getParameter("unidade");

        if (numeroStr == null || unidade == null || 
            numeroStr.trim().isEmpty() || 
            !numeroStr.matches("^-?\\d+$")) { 
            
            response.sendRedirect("erro.html");
            return;
        }

        try {
            double valor = Double.parseDouble(numeroStr);
            String resultado = calcularConversao(valor, unidade);
            
            response.sendRedirect(request.getContextPath() + "/resultado.html?resultado=" + URLEncoder.encode(resultado, "UTF-8")); 
                       
        } catch (NumberFormatException | AssertionError e) {
            response.sendRedirect("erro.html");
        }
    }
    
    private String calcularConversao(double valor, String unidade) {
        switch (unidade) {
            case "milha_metro":
                return String.format("%.2f milhas equivalem a %.2f metros", valor, (valor * 1609.34));
            case "metro_milha":
                return String.format("%.2f metros equivalem a %.2f milhas", valor, (valor / 1609.34));
            case "pe_metro":
                return String.format("%.2f pés equivalem a %.2f metros", valor, (valor * 0.3048));
            case "metro_pe":
                return String.format("%.2f metros equivalem a %.2f pés", valor, (valor / 0.3048));
            default:
                throw new AssertionError();
        }
    }
}