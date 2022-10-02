public class Aula {
    public static void main(String[] args) {
        ContaBanco p1 = new ContaBanco();
        p1.setNumConta(1111);
        p1.setDono("Jubileu");
        p1.abrirConta("CC");
        p1.criarDebito();
        p1.criarCCredito();
        p1.depositar(0);
        p1.limiteCredito(300);
        p1.pagarCredito(500);
        p1.pagarFatura(300);
        p1.estadoAtual();
    }
}