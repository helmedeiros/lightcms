#language: pt

Funcionalidade: Para utilizar o CMS, o usuário deve estar logado.

Cenario: Tentativa de autenticação utilizando usuário e senha válidos
    Dado que estou na página de Login
    Quando eu informo o usuário "bsouza"
    E informo a senha "test123"
    E clico no botão "validar"
    Então devo ser redirecionado para a página Home