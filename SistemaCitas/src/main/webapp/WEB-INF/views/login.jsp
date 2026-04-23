<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="es">
<head>
    <title>Acceso - Clínica Pacífico</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

<h2>Bienvenido</h2>

<!-- LOGIN -->
<h3>Iniciar Sesión</h3>
<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="text" name="username" placeholder="Usuario" required><br><br>
    <input type="password" name="password" placeholder="Contraseña" required><br><br>
    <button type="submit">Ingresar</button>
</form>

<p style="color:red;">${errorLogin}</p>

<hr>

<!-- REGISTRO -->
<h3>Crear Cuenta</h3>
<form action="${pageContext.request.contextPath}/registro" method="post">
    <input type="text" name="nuevoUsuario" placeholder="Nuevo usuario" required><br><br>
    <input type="password" name="nuevaPassword" placeholder="Contraseña" required><br><br>
    <button type="submit">Registrarse</button>
</form>

<p style="color:red;">${errorRegistro}</p>

</body>
</html>
