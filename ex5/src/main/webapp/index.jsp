<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/tags/includes.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sistema Academia</title>
    <style>
        :root {
            --primary-color: #2c3e50;
            --secondary-color: #3498db;
            --accent-color: #e74c3c;
            --light-color: #ecf0f1;
            --dark-color: #2c3e50;
        }
        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f7fa;
            color: var(--dark-color);
        }
        
        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 30px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
            text-align: center;
        }
        
        h1 {
            color: var(--primary-color);
            margin-bottom: 40px;
            font-size: 2.5em;
            border-bottom: 3px solid var(--secondary-color);
            padding-bottom: 10px;
            display: inline-block;
        }
        
        .menu-cards {
            display: flex;
            justify-content: center;
            gap: 30px;
            flex-wrap: wrap;
            margin-top: 40px;
        }
        
        .card {
            width: 250px;
            background: white;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 3px 10px rgba(0,0,0,0.1);
            transition: transform 0.3s, box-shadow 0.3s;
            text-decoration: none;
            color: inherit;
            display: flex;
            flex-direction: column;
        }
        
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 20px rgba(0,0,0,0.15);
        }
        
        .card-header {
            background-color: var(--secondary-color);
            color: white;
            padding: 20px;
            font-size: 1.3em;
            font-weight: bold;
            text-align: center;
            flex: 0 0 auto;
        }
        
        .card-body {
            padding: 25px;
            background-color: var(--light-color);
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-align: center;
        }
        
        .card-body p {
            margin: 0;
            color: var(--dark-color);
            line-height: 1.5;
        }
        
        .icon {
            font-size: 2.5em;
            margin-bottom: 15px;
            color: var(--secondary-color);
        }
        
        footer {
            margin-top: 50px;
            text-align: center;
            color: #7f8c8d;
            font-size: 0.9em;
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <div class="container">
        <h1>Sistema de Gestão de Treinos</h1>
        
        <div class="menu-cards">
            <a href="${contextPath}/Treinos" class="card">
                <div class="card-header">
                    <i class="fas fa-dumbbell icon"></i>
                    Planos de Treino
                </div>
                <div class="card-body">
                    <p>Gerencie os planos de treino dos alunos</p>
                </div>
            </a>
            
            <a href="${contextPath}/Alunos" class="card">
                <div class="card-header">
                    <i class="fas fa-users icon"></i>
                    Alunos
                </div>
                <div class="card-body">
                    <p>Cadastre e administre os alunos</p>
                </div>
            </a>
        </div>
        
        <footer>
            Sistema Academia © <%= java.time.Year.now().getValue() %>
        </footer>
    </div>
</body>
</html>