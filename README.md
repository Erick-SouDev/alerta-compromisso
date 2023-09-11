

<h1> Projeto "Agendador de Eventos com Spring MVC, PostgreSQL, Thymeleaf e Notificações Automáticas por Email"</h1>
## Resumo Detalhado:

### Introdução:
O projeto "Agendador de Eventos" é uma aplicação web desenvolvida utilizando a tecnologia Spring MVC como framework principal. O objetivo do projeto é criar uma plataforma que permita aos usuários agendar eventos, atualizar agendas e receber notificações automáticas por email. Para realizar as notificações automáticas, o projeto utilizará o agendamento de tarefas (`@Scheduled`).

### Tecnologias Utilizadas:
 ![spring](https://github.com/Erick-SouDev/minha-biblioteca/assets/139890795/6f8f4335-4aef-488b-bf78-ff0bb15335ee)
 ![thymeleaf](https://github.com/Erick-SouDev/minha-biblioteca/assets/139890795/5562d495-392e-42b9-98b1-b47c0f211ef0)
 ![postgres](https://github.com/Erick-SouDev/minha-biblioteca/assets/139890795/7d8e3a6a-b0f9-4235-b1bb-c71207d94a97)

### Funcionalidades Principais:
- Cadastro de Eventos: Os usuários podem cadastrar eventos, incluindo informações como título, data, hora, descrição e localização.
- Atualização de Agendas: Os usuários podem atualizar suas agendas, adicionando ou removendo eventos agendados.
- Notificações Automáticas por Email: A aplicação utiliza tarefas agendadas (`Scheduled Tasks`) para verificar periodicamente os eventos agendados e enviar notificações por email aos participantes registrados nos eventos. A notificação inclui detalhes do evento, como data, hora e local.

### Arquitetura da Aplicação:
A aplicação segue uma arquitetura MVC (Model-View-Controller), onde:
- O Model é responsável pelo acesso ao banco de dados PostgreSQL para recuperar e armazenar informações sobre eventos e agendas.
- O Controller lida com as solicitações dos usuários, processa os dados e chama os serviços apropriados.
- A View (Thymeleaf) é responsável por renderizar as páginas HTML dinâmicas para os usuários.

### Fluxo de Trabalho:
1. Um usuário acessa a aplicação e faz login ou se cadastra.
2. O usuário pode visualizar eventos existentes, cadastrar novos eventos ou atualizar sua agenda.
3. A aplicação verifica periodicamente os eventos agendados usando tarefas agendadas.
4. Quando um evento está próximo, a aplicação envia automaticamente notificações por email aos participantes registrados no evento, utilizando o recurso de tarefas agendadas.

### Benefícios:
- Facilita o agendamento e gerenciamento de eventos.
- Mantém os usuários informados sobre os eventos agendados através de notificações por email automáticas, graças ao uso do agendamento de tarefas (`Scheduled Tasks`).
- Utiliza tecnologias modernas e populares para desenvolver uma aplicação web robusta e escalável.

O "Agendador de Eventos com Spring MVC, PostgreSQL, Thymeleaf e Notificações Automáticas por Email" é um projeto que visa simplificar o processo de organização e acompanhamento de eventos, proporcionando uma experiência conveniente e automatizada para os usuários, com notificações agendadas para garantir que eles estejam sempre atualizados sobre seus eventos.
