import java.util.Scanner;

public class arvorebinariamorse {

    static class no {
        Character caractere;
        no esquerda;
        no direita;

        public no() {
            this.caractere = null;
            this.esquerda = null;
            this.direita = null;
        }
    }

    private final no raiz;

    public arvorebinariamorse() {
        raiz = new no();
        inicializar();
    }

    private void inicializar() {

        inserir(".-", 'a');
        inserir("-...", 'b');
        inserir("-.-.", 'c');
        inserir("-..", 'd');
        inserir(".", 'e');
        inserir("..-.", 'f');
        inserir("--.", 'g');
        inserir("....", 'h');
        inserir("..", 'i');
        inserir(".---", 'j');
        inserir("-.-", 'k');
        inserir(".-..", 'l');
        inserir("--", 'm');
        inserir("-.", 'n');
        inserir("---", 'o');
        inserir(".--.", 'p');
        inserir("--.-", 'q');
        inserir(".-.", 'r');
        inserir("...", 's');
        inserir("-", 't');
        inserir("..-", 'u');
        inserir("...-", 'v');
        inserir(".--", 'w');
        inserir("-..-", 'x');
        inserir("-.--", 'y');
        inserir("--..", 'z');

        inserir("-----", '0');
        inserir(".----", '1');
        inserir("..---", '2');
        inserir("...--", '3');
        inserir("....-", '4');
        inserir(".....", '5');
        inserir("-....", '6');
        inserir("--...", '7');
        inserir("---..", '8');
        inserir("----.", '9');
    }

    public void inserir(String codigomorse, char caractere) {

        no atual = raiz;

        for (int i = 0; i < codigomorse.length(); i++) {

            char simbolo = codigomorse.charAt(i);

            if (simbolo == '.') {

                if (atual.esquerda == null) {
                    atual.esquerda = new no();
                }

                atual = atual.esquerda;

            } else if (simbolo == '-') {

                if (atual.direita == null) {
                    atual.direita = new no();
                }

                atual = atual.direita;

            } else {

                System.out.println("código morse inválido.");
                return;
            }
        }

        atual.caractere = Character.toLowerCase(caractere);
    }

    public Character buscar(String codigomorse) {

        no atual = raiz;

        for (int i = 0; i < codigomorse.length(); i++) {

            char simbolo = codigomorse.charAt(i);

            if (simbolo == '.') {

                atual = atual.esquerda;

            } else if (simbolo == '-') {

                atual = atual.direita;

            } else {

                return null;
            }

            if (atual == null) {
                return null;
            }
        }

        return atual.caractere;
    }

    public String buscarmorse(char caractere) {

        caractere = Character.toLowerCase(caractere);

        return buscarmorserecursivo(
                raiz,
                caractere,
                ""
        );
    }

    private String buscarmorserecursivo(
            no no,
            char caractere,
            String caminho) {

        if (no == null) {
            return null;
        }

        if (no.caractere != null &&
                no.caractere == caractere) {

            return caminho;
        }

        String esquerda =
                buscarmorserecursivo(
                        no.esquerda,
                        caractere,
                        caminho + "."
                );

        if (esquerda != null) {
            return esquerda;
        }

        return buscarmorserecursivo(
                no.direita,
                caractere,
                caminho + "-"
        );
    }

    public String codificarmensagem(String mensagem) {

        StringBuilder resultado =
                new StringBuilder();

        mensagem = mensagem.toLowerCase();

        for (int i = 0; i < mensagem.length(); i++) {

            char caractere =
                    mensagem.charAt(i);

            if (caractere == ' ') {

                resultado.append("/ ");

            } else {

                String codigo =
                        buscarmorse(caractere);

                if (codigo != null) {

                    resultado
                            .append(codigo)
                            .append(" ");

                } else {

                    resultado.append("? ");
                }
            }
        }

        return resultado.toString().trim();
    }

    public String decodificarmensagem(String mensagemmorse) {

        StringBuilder resultado =
                new StringBuilder();

        String[] codigos =
                mensagemmorse.trim().split("\\s+");

        for (String codigo : codigos) {

            if (codigo.equals("/")) {

                resultado.append(" ");

            } else {

                Character caractere =
                        buscar(codigo);

                if (caractere != null) {

                    resultado.append(caractere);

                } else {

                    resultado.append("?");
                }
            }
        }

        return resultado.toString();
    }

    public void exibirarvore() {

        System.out.println();

        System.out.println(
                "árvore binária de código morse"
        );

        System.out.println(
                ". = esquerda | - = direita"
        );

        System.out.println();

        exibirarvorerecursivo(
                raiz,
                0,
                "raiz"
        );
    }

    private void exibirarvorerecursivo(
            no no,
            int nivel,
            String caminho) {

        if (no == null) {
            return;
        }

        exibirarvorerecursivo(
                no.direita,
                nivel + 1,
                "-"
        );

        for (int i = 0; i < nivel; i++) {
            System.out.print("     ");
        }

        if (no.caractere == null) {

            System.out.println(
                    caminho + " [ ]"
            );

        } else {

            System.out.println(
                    caminho + " [" +
                            no.caractere + "]"
            );
        }

        exibirarvorerecursivo(
                no.esquerda,
                nivel + 1,
                "."
        );
    }

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        arvorebinariamorse arvore =
                new arvorebinariamorse();

        String opcao;

        do {

            System.out.println();
            System.out.println(
                    "===== árvore morse ====="
            );

            System.out.println(
                    "1 - codificar mensagem"
            );

            System.out.println(
                    "2 - decodificar mensagem morse"
            );

            System.out.println(
                    "3 - buscar código morse de um caractere"
            );

            System.out.println(
                    "4 - buscar caractere por código morse"
            );

            System.out.println(
                    "5 - inserir caractere"
            );

            System.out.println(
                    "6 - exibir árvore"
            );

            System.out.println(
                    "0 - sair"
            );

            System.out.print(
                    "escolha uma opção: "
            );

            opcao = scanner.nextLine();

            switch (opcao) {

                case "1":

                    System.out.print(
                            "digite a mensagem: "
                    );

                    String mensagem =
                            scanner.nextLine();

                    System.out.println(
                            "código morse:"
                    );

                    System.out.println(
                            arvore.codificarmensagem(
                                    mensagem
                            )
                    );

                    break;

                case "2":

                    System.out.print(
                            "digite a mensagem em morse: "
                    );

                    String mensagemmorse =
                            scanner.nextLine();

                    System.out.println(
                            "mensagem:"
                    );

                    System.out.println(
                            arvore.decodificarmensagem(
                                    mensagemmorse
                            )
                    );

                    break;

                case "3":

                    System.out.print(
                            "digite uma letra ou número: "
                    );

                    String entrada =
                            scanner.nextLine();

                    if (entrada.isEmpty()) {

                        System.out.println(
                                "entrada inválida."
                        );

                        break;
                    }

                    char caractere =
                            entrada.charAt(0);

                    String codigo =
                            arvore.buscarmorse(
                                    caractere
                            );

                    if (codigo != null) {

                        System.out.println(
                                caractere +
                                        " = " +
                                        codigo
                        );

                    } else {

                        System.out.println(
                                "caractere não encontrado."
                        );
                    }

                    break;

                case "4":

                    System.out.print(
                            "digite o código morse: "
                    );

                    String codigobusca =
                            scanner.nextLine();

                    Character resultado =
                            arvore.buscar(
                                    codigobusca
                            );

                    if (resultado != null) {

                        System.out.println(
                                codigobusca +
                                        " = " +
                                        resultado
                        );

                    } else {

                        System.out.println(
                                "código não encontrado."
                        );
                    }

                    break;

                case "5":

                    System.out.print(
                            "digite o caractere: "
                    );

                    String novo =
                            scanner.nextLine();

                    if (novo.isEmpty()) {

                        System.out.println(
                                "caractere inválido."
                        );

                        break;
                    }

                    System.out.print(
                            "digite o código morse: "
                    );

                    String novocodigo =
                            scanner.nextLine();

                    arvore.inserir(
                            novocodigo,
                            novo.charAt(0)
                    );

                    System.out.println(
                            "caractere inserido."
                    );

                    break;

                case "6":

                    arvore.exibirarvore();

                    break;

                case "0":

                    System.out.println(
                            "programa encerrado."
                    );

                    break;

                default:

                    System.out.println(
                            "opção inválida."
                    );
            }

        } while (!opcao.equals("0"));

        scanner.close();
    }
}