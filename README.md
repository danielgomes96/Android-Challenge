Desafio Viajabessa

Ambiente de instalação
1: Instale o Android Studio;
2: Abra a aplicação;
3: Sincronize o projeto;
4: Rode o aplicativo em um simulador ou em um device externo.
Automação
Ktlint - a task valida se o padrão do código está de acordo com o lint. Utilize o comando ./gradlew ktlint para que a validação seja feita.

KtlintFormat - esta tarefa modifica o código para que ele siga o padrão do lint. Utilize o comando ./gradlew ktlintFormat para que o código seja ajustado.

Test - Utilize o comando ./gradlew test para que todos os testes sejam executados.

Arquitetura
A aplicação busca em sua arquitetura o desacoplamento e a escalabilidade, fazendo uso do Clean Architecture e do MVVM.

Principais dependências
Koin - injeção de dependências

Biblioteca escolhida por sua simples implementação. Como ponto negativo, há alguma perda de performance quando comparada com outras concorrentes, como o Dagger. Não há uma perda significativa para esta aplicação.

Coroutines - lidando com threads e assincronismo

Lib sugerida pela Google e com um bom funcionamento com o Live Data, além de fazer bom uso das threads e da Thread Pool do dispositivo, melhorando a performance da aplicação. Quando comparada com a sua principal concorrente, o RxJava, tem como ponto positivo o seu menor tamanho e negativo o seu tratamento de erros, um pouco mais manual.

Room - persistência de dados

Camada de abstração sobre o SQLite, o Room é um facilitador para persistir dados no banco do aparelho. Outro ponto a ser destacado, é a sua boa integração com o Live Data, o que permite que a View observe diretamente os dados do banco.

MockK - testes

O MockK é uma lib de testes para a linguagem Kotlin. Sua utilização é simples e tem como ponto positivo perante aos concorrêntes, a possibilidade de mockar métodos de Objects e Companion Objects sem precisar criar interfaces. Por outro lado, é uma

teca exclusiva para Kotlin, não funcionando com a linguagem Java.

Glide - carregamento de imagens de urls

Uma das bibliotecas mais utilizadas no mercado, tem no Picasso a sua principal concorrente. Quando comparadas, apresenta vantagens e desvantagens. Algumas vantagens são o melhor uso de memória e o suporte a GIF animado, por outro lado, tem como perde em velocidade de carregamento das imagens e o seu tamanho em si.

Retrofit - requisições HTTP

Retrofit é a biblioteca mais difundida para lidar com requisições HTTP, além de possuir uma fácil implementação.