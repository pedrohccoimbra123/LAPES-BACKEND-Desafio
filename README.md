# LAPES-Desafio

Bom, eu fiz o primeiro commit ainda na terça-feira com o projeto incompeto com o que eu consegui fazer naquele determinado momento. Porém, na sexta, soube que poderia entregar até Meia Noite de sábado (ops!!), então passei praticamente o sábado tentando fazer a integração dos produtos e usuarios com um carrinho de compras, lá pelas 21 horas e com uma StackTrace infinita de erros eu acabei apenas fazendo uma classe usuario, bem com a atualização de alguns métodos como ordenação por faixa de preço, produtos mais e menos vendidos e etc..

# O que utilizei para desenvolver este projeto
IntelliJ IDEA 2023.2
PgAdmin4
Insomnia 2023.5.8

# Framework Escolhido
Spring 3.1.3
# Banco de Dados escolhido
PostgreSQL 15.9
# ORM escolhido
JPA data
# Dependências utilizadas
  Lombok - Java annotation library which helps to reduce boilerplate code. 
  
  Flyway Migration SQL - Version control for your database so you can migrate from any version      
 
  SpringWeb - Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
  
  PostgreSQL Driver - A JDBC and R2DBC driver that allows Java programs to connect to a PostgreSQL database using standard, database independent Java code.
  
  Spring Data JPA - Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.

  #Documentação de Rotas (Swagger)

  # Listar todos os Produtos(GET):
  - localhost:8080/product/allProducts
  
  # Listar Produtos pela faixa de preço:
  - localhost:8080/product/products/pricerange/{minPrice}/{maxPrice}
    Onde minPrice é o preço minímo estipulado e o MaxPrice o preço máximo.
  
  # Buscar Produto pelo nome(GET):
-  localhost:8080/product/products/byname/{productName}
  Onde productName é o nome do produto.
# Deletar uma categoria(DELETE):
  -  localhost:8080/product/products/category/{category}
  Onde categoria é a categoria escolhida.

# Listar os produtos mais vendidos(GET):
  - localhost:8080/product/unitsold/most
# Listar os produtos menos vendidos(GET):
  -  localhost:8080/product/unitsold/least
# Deletar produtos pelo id (DELETE)
- localhost:8080/product/{id}
  Id é o id do produto
# Update Product pelo id (PUT)
 - localhost:8080/product/updateProduct

# Adicionar Produto (POST)
- localhost:8080/product/addProduct

# Adicionar usuario (POST)
- localhost:8080/usuario/addUser
# Listar todos os usuarios disponiveis (GET)
- localhost:8080/usuario/getUsers

# Existe uma pasta com capturas de tela que testa todos esses métodos

# Diagrama de ER (Entidade-Relacionamento):
Tendo em vista que, como é possível ver pelos commits, eu não consegui fazer a integração do carrinho de compras com o usuário, o que acabou não sendo possível linkar o diagrama aqui
# Estrutura de Pasta 
MVC - Model View Controller, onde é possível verificar as estruturas de controle presentes no projeto

#Procedimento de instalação
Bom, eu fiz o projeto de forma local, então disponibilizei o arquivo de backup da database para ser possível fazer o clone.


   
  
