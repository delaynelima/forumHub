Challenge Back End Forum Hub

O FórumHub é um projeto desenvolvido Challenge Back End da Alura, com o objetivo de aprofundar os conhecimentos de lógica através de fórum online no backend.

Neste sistema, usuários podem postar dúvidas, interagir com tópicos e responder perguntas. O desafio foi implementar uma API REST capaz de gerenciar tópicos,
usuários e cursos, permitindo:

Criar, listar, atualizar e deletar tópicos (CRUD completo)
Listar cursos e usuários.
O projeto reforça conceitos de API REST, persistência relacional, segurança com JWT e boas práticas de desenvolvimento utilizando Spring Boot.


: Tecnologias utilizadas:
Java 17**
- Spring Boot 3**
- Spring Security + JWT** (para login e proteção de rotas)
- Spring Data JPA** (acesso ao banco de dados)
- MySQL** (persistência dos dados)
- Lombok(para reduzir a verbosidade no código)
- Insomnia(para testar as requisições)


: Estrutura do projeto: 
#br.com.alura.forumhub 

controller # Endpoints REST

domain # Entidades, DTOs e enums

repository # Interfaces JPA

service # Regras de negócio

security # Filtros e configuração JWT 

ForumHubApplication.java

Segurança:
: Autenticação via JWT
Usuários só podem alterar/excluir seus próprios tópicos

Cobertura de Testes
: Todas as rotas da API foram testadas manualmente utilizando o Insomnia, garantindo o funcionamento de autenticação, CRUD de usuários, cursos e tópicos, além das regras de negócio e segurança (JWT).

Autor
: Projeto baseado no curso da Alura, com customizações realizadas por [Delayne Fernandes].
