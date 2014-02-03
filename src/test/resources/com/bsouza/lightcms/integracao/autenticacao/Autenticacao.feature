#language: pt

Funcionalidade: Para utilizar o CMS, o usuário deve estar logado.

Cenario: Tentativa de autenticação utilizando usuário e senha válidos
    Dado que estou na página de login
    Quando eu informo o usuário "bsouza"
    E informo a senha "root"
    E clico no botão "validar"
    Então devo ser redirecionado para a página Home
    
Cenario: Tentativa de autenticação com senha inválida
    Dado que estou na página de login
    Quando eu informo o usuário "bsouza"
    E informo a senha "teste"
    E clico no botão "validar"
    Então devo ver a mensagem "Falha na autententicação! Por favor revise suas credenciais ou, se o problema persistir, contata-te o administrador." 
    