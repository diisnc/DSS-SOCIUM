# DSS-SOCIUM

Trabalho de DSS que permite gerir quotas de sócios de uma organização através de uma interface gráfica em Java.

## Separação de responsabilidades (MVC)

Neste projeto existem duas classes importantes, `Trabalho1` é o controlador, além disso, tem o `main()` e por isso inicia a aplicação. `Trabalho1UI` é a view e representa uma interface gráfica SWING.

Para o modelo, por ser um simples HashMap, não foi criada uma classe, apenas um campo privado no controlador e um método `getMembers()`.

A função `main()`, dentro da classe `Trabalho1`, trata de instanciar a view e o controlador e passar a instância do controlador para a view. Isto é necessário porque a view precisa de enviar eventos (como submissão de formulários) para o controlador.

Além disto, o controlador é um `observable` e a view é um `observer`, pelo que quando o controlador efetuar alterações ao modelo (`HashMap membros`) estas são propagadas para a view a partir de uma chamada a `notifyObservers()` passando `this.members` como parâmetro.

Seguem então dois exemplos:

* O utilizador cria um membro a partir da GUI. A view envia o evento para o controlador. O controlador atualiza o modelo e chama `notifyObservers()`. A view é atualizada.

* Um membro é criado internamente, sem ser pela GUI. O controlador recebe o evento (de onde ele hipoteticamente vier), atualiza o modelo e chama `notifyObservers()`. A view é atualizada.
