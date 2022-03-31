# read-csv-file-api
Projeto para leitura de arquivos CSV

Para rodar este projeto basta instalar uma IDE que suporta o projeto Spring ex..IntelliJ ou STS;

Foi criado uma inteface em bootstrap 4 para facilitar o upload do arquivo .csv;

Projeto esta configurado para rodar na porta 8081;

Temos as seguintes operações implementadas:

POST - localhost:8081/fileupload ao completar a ação automaticamente sera redirecionado para o GET abaixo
GET - localhost:8081/ que contera a lista carregada.

GET - localhost:8081/produtorMaiorIntervalo --> Produtor com maior intervalo entre dois prêmios consecutivos
GET - localhost:8081/produtorObteveDoisPremiosRapido --> Produtor que obteve dois prêmios mais rápido


OBS: POR DEFAULT A Classe ICSVParcer utiliza o separador "," e não o ";", caso necesario somente alterar no construtor.
