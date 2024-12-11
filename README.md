 # ######################################## # 
 # ####### API para Sistema Medico ######## #
 # ######################################## #
 
 # ####### Instalação ######## #

Faze inicial

    1- Baixe o repositorio no link abaixo
        https://github.com/IVictorOli/sismed


    Descompacte o arquivo sismed-main.zip no diretório:
        C:\Users\<nome_do_usuario> \Documents\workspace-spring-tool-suite-4-4.27.0.RELEASE

Criação e configuração do banco.
    No PostgreSQL crie o Banco: sismed
    Restaure o arquivo: sismed.sql no banco sismed recém-criado

Opcional
    O Instalados Offline de Repositórios:
    baixe o arquivo InstaladorOffLine.exe no repositório:
     https://github.com/IVictorOli/Drive
    instale o programa na pasta: C:\Users\<nome_do_usuario>\.m2

Importando o projeto
    Importe o projeto sismed que esta na pasta  workspace-spring-tool-suite-4-4.27.0.RELEASE para 
    sua Dev Suite (Preferencialmente Eclipse ou Spring Tools Suit)

Configurando banco
    Configure corretamente os dados do seu banco no arquivo:
        sismed-main\src\main\resources\application.properties
    Dados a serem alterado:
        spring.datasource.url=jdbc:postgresql://localhost:5432/sismed
        spring.datasource.username=seuusuario
        spring.datasource.password=suasenha

Salve as alterações

Force um Update Mavem Project
    Inicie a scr/main/java/com.sismed.api.SismedApplication.java como um Spring Boot App
    Verifique possíveis logs de erro


# ####### Links uteis ######## #

 # swagger
 Pagina de teste com swagger
 http://localhost:8080/swagger-ui/index.html

