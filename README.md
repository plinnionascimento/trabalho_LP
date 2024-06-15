

## Banco de Dados: SQLite

### Motivo da Escolha
A escolha pelo SQLite foi baseada na familiaridade e experiência prévia. Já tive experiências anteriores com este banco de dados tanto durante meus estudos na faculdade quanto em projetos profissionais, o que facilitou a tomada de decisão e agilizou o desenvolvimento.

### Estrutura do Banco de Dados
Foram criadas três tabelas principais:
- Tabela "Usuários"
- Tabela "Amigos"
- Tabela "Mensagens"

Além disso, foram projetadas mais duas tabelas, "User" e "Login_Historico", que não foram utilizadas no estágio do projeto, mas foram planejadas para eventual necessidade.

### Operações SQL Utilizadas
Durante o desenvolvimento do projeto, utilizamos as operações básicas do SQL:
- EXCLUIR
- ATUALIZAR
- SELECIONAR
- INSERIR

## Linguagem e Ambiente de Desenvolvimento
Para a criação do back-end e da interface do simulador, utilizamos a linguagem Java, com o ambiente de desenvolvimento Eclipse. Optei pelo Eclipse pela sua simplicidade e facilidade na criação de interfaces gráficas. Como este foi meu primeiro projeto de tal escala, preferi utilizar uma ferramenta com a qual eu estava mais familiarizado, mesmo que outras opções mais completas como IntelliJ IDEA estejam disponíveis.

### Interfaces Criadas
Foram criadas sete interfaces para interação com o simulador:
- Adicionar_Amigos
- Enviar_Mensagens
- Excluir_Amigos
- Ver_Amigos
- Ver_Cadastro
- View_Primeira_Tela (Tela de Login)
- View_Segunda_Tela (Menu de Opções)

As interfaces foram criadas manualmente, minimizando a utilização extensiva de código para agilizar o processo de desenvolvimento.

### Classes Criadas
Duas classes principais foram inovadoras no projeto:
- Classe "Connect": Responsável por estabelecer a conexão com o banco de dados SQLite e gerenciar a comunicação entre as interfaces e o banco de dados.
- Classe "Principal": Utilizada para agrupar códigos de conexão com o banco de dados e de interação entre as interfaces.

### Utilização do arquivo pom.xml
O arquivo pom.xml foi utilizado para adicionar propriedades e configurar a conexão com o banco de dados. Além disso, essa configuração incluiu a previsão da versão do Java (3.21.0.1) utilizada no projeto. Houve uma importação da pasta do Java 3.44.00 para o Eclipse para permitir o uso de algumas bibliotecas mais recentes.

### Modelo de Classes
Foram criados três modelos de classes - "Amigos", "Mensagens" e "Usuários" - com o mesmo nome das tabelas do banco de dados. Essas classes continham métodos void, getters e conexões para facilitar as chamadas do banco de dados pelas interfaces.

### Pacote "View"
Um pacote "View" foi criado para abrigar o back-end e as interfaces do projeto.

### Venda de Itens
Além das funcionalidades tradicionais de uma rede social, este simulador permite aos usuários vender itens entre si. Essa funcionalidade adiciona uma camada de interação econômica entre os usuários, promovendo trocas e vendas de itens pessoais.

---

Este README serve como um guia básico para entender a estrutura e funcionalidades do projeto Simulador de Rede Social. Certifique-se de verificar o código-fonte e explorar cada parte do sistema para uma compreensão mais profunda.



![image](https://github.com/plinnionascimento/trabalho_LP/assets/151463456/10fbe7fc-3d44-4755-98ce-8776445b0baf)



![image](https://github.com/plinnionascimento/trabalho_LP/assets/151463456/ed1063dd-e17d-43bb-b21d-c9f335cadc80)



![image](https://github.com/plinnionascimento/trabalho_LP/assets/151463456/576ba32f-c559-462a-95df-80a0e49e8c89)

![image](https://github.com/plinnionascimento/trabalho_LP/assets/151463456/fdcbd863-4c0f-4ad9-bae8-78289db30fcb)



![image](https://github.com/plinnionascimento/trabalho_LP/assets/151463456/e598dde5-7617-471d-8444-9107bc8833c8)



![image](https://github.com/plinnionascimento/trabalho_LP/assets/151463456/5e8dd24e-ab7b-424e-aaab-b21dc8f78770)



![image](https://github.com/plinnionascimento/trabalho_LP/assets/151463456/e8871680-bbf4-405f-b084-0631a2237502)

![image](https://github.com/plinnionascimento/trabalho_LP/assets/151463456/52baf8c3-bf0a-4266-acc5-fa47881a4f27)

![image](https://github.com/plinnionascimento/trabalho_LP/assets/151463456/1435f2f5-67bc-4622-a84a-67205aa7d6ae)






