# ativ-rmi
___

Este repositório armazena uma implementação básica de um serviço de nomes em RMI num ambiente docker. 

O projeto divide-se em três módulos:

- **ativ-rmi-registry** Que trata-se de um módulo que cria o Registry na porta 10999. Este mesmo módulo expõe a implementação NamingServiceImpl da interface NamingService no Registry criado. De maneira que a mesma possa ser acessado por outros módulos.
- **ativ-rmi-server** trata-se de um módulo, que recupera a instância do Registry criado no módulo acima, recupera a instância do NamingService exposto no registry e adiciona a implementação de um objeto Remoto "CalculadoraImpl" através do método .save de NamingService.
- **ativ-rmi-client** Por fim, este módulo serve apenas para recuperar a instância do Registry na porta 10999 do primeiro módulo, recuperar a instância do NamingService exposto e recuperar do NamingService, a instância exposta do Objeto remoto CalculadoraImpl (por meio da interface Calculadora) para então realizar uma chamada de procedimento remota para o objeto exposto.

Para executar este projeto, siga as seguintes instruções:

- Cerfique-se de que os seguintes programas estão instalados corretamente em sua máquina:
	- Docker
	- Docker Compose
	- Maven
- Com um terminal aberto no diretório root do projeto, execute os seguintes comandos:
	- `mvn clean install`
	- `sudo docker-compose up -d`

Executado o comando a cima, três imagens serão criadas e um container será instanciado para cada imagem. Após a criação das imagens e a instância dos containers, o cliente realizará uma chamada remota ao método calculate que irá retornar o resultado de uma operação de soma que pode ser acompanhada por meio dos LOGs.

Você pode conferir o resultado da operação de soma no módulo cliente através do seguinte comando:
- `sudo docker logs ativ-rmi-client`

Para remover as imagens criadas e os containers em execução, rode o seguinte comando:
- `sudo docker-compose down --rmi all`