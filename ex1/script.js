document.addEventListener('DOMContentLoaded', function() {
    const text = document.getElementById("p1");
    let colors = ["red", "green", "blue"];
    let index = 0;
    
    text.style.color = colors[index]; // da load na pagina com o texto em vermelho (index 0)
    
    text.onclick = function() {
        index = (index + 1) % colors.length; // avanca o index para a mudanca das cores (0→1→2→0...)
        text.style.color = colors[index];
    };
});