public class ContaBanco {
    //Atributos
    public int numConta;
    public String tipo;
    public String dono;
    private float saldo;
    private boolean status;
    public boolean debito;
    public boolean cCredito;
    public int credito;
    public int fatura;

    //Métodos Personalizados
    public void estadoAtual() {
        System.out.println("-------------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status " + this.getStatus());
        System.out.println("Cartão de débito: " + this.getDebito());
        System.out.println("Cartão de Crédito: " + this.getCCredito());
        System.out.println("Limite de crédito: " + this.getCredito());
        System.out.println("Valor da fatura atual: " + this.getFatura());
    }
    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true);
        if ("CC".equals(t)) {
            this.setSaldo(50);
        } else if ("CP".equals(t)) {
            this.setSaldo(150);
        }
        System.out.println("Conta aberta com sucesso!");
    }
    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Conta não pode ser fechada porque ainda tem dinheiro");
        } else if(this.getSaldo() < 0) {
            System.out.println("Conta não pode ser fechda pois tem débito");
        } else if(this.getStatus() == false) { 
            System.out.println("Conta não pode ser fechada pois ela não existe");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }
    public void depositar(float v) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + v);
            System.out.println("Depósito realizado com sucesso na conta de " + this.getDono());
        } else {
            System.out.println("Impossível depositar numa conta fechada");
        }
    }
    public void sacar(float v) {
        if (this.getStatus()) {
            if (this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Saque realizado com sucesso na conta de " + this.getDono());
            } else {
                System.out.println("Saldo insuficiente para o saque desejado");
            }
        } else {
            System.out.println("Impossível sacar de uma conta fechada");
        }
    }
    public void pagarMensal() {
        int v = 0;
        if (this.getTipo() == "CC") {
            v = 12;
        } else if (this.getTipo() == "CP") {
            v = 20;
        }
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Mensalidade paga com sucesso por " + this.getDono());
        } else {
            System.out.println("Impossível pagar uma conta fechada");
        }
    }
    public void criarDebito() {
        if (this.getStatus()) {
            if (this.getDebito()) {
                System.out.println("Não é possível criar outro cartão de débito, pois a conta já possui um");
            } else {
                this.setDebito(true);
                System.out.println("Cartão de débito criado com sucesso!");
            }
        } else {
            System.out.println("Não é possível criar um cartão de débito sem ter uma conta bancária antes");
        }
    }
    public void pagarDebito(float v) {
        if (this.getDebito()) {
            if (this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.println("O pagamento em débito no valor de " + v + " foi concluído. Agora restam " + this.getSaldo() + " na sua conta");
            } else {
                System.out.println("Não é possível realizar uma transação maior que o saldo");
            }
        } else {
            System.out.println("Não é possível realizar a operação, pois a conta não possui cartão de débito");
        }
    }
    public void criarCCredito() {
        if (this.getCCredito()) {
            System.out.println("Não é possível criar um novo cartão de crédito, pois a conta já possui um");
        } else {
            this.setCCredito(true);
            System.out.println("Cartão de crédito criado com sucesso!");
        }
    }
    public void limiteCredito(int i) {
        if (this.getCCredito()) {
            this.setCredito(this.getCredito() + i);
        } else {
            System.out.println("Não é possível determinar um limite de crédito sem, antes, ter um cartão de crédito");
        }
    }
    public void pagarCredito(int i) {
        if (this.getCCredito()) {
            if (this.getCredito() >= i) {
                this.setCredito(this.getCredito() - i);
                this.setFatura(this.getFatura() + i);
                System.out.println("Compra APROVADA no valor de " + i + " no crédito.");
            } else {
                System.out.println("Limite de crédito insuficiente");
            }
        } else {
            System.out.println("Operação negada, a conta não possui cartão de crédito");
        }
    }   
    public void pagarFatura(int i) {
        if (this.getCCredito()) {
            if (this.getSaldo() >= this.getFatura()) {
                if (i <= this.getFatura()) {
                    this.setFatura(this.getFatura() - i);
                    this.setCredito(this.getCredito() + i);
                    System.out.println("Fatura no valor de " + i + " paga com sucesso!");
                } else {
                    System.out.println("Valor acima da fatura");
                }
            } else {
                System.out.println("Saldo insuficiente");
            }
        } else {
            System.out.println("A conta não possui cartão de crédito");
        }
    }

    //Métodos especiais
    public ContaBanco(){
        this.saldo = 0; 
        this.status = false;
    }
    public int getNumConta(){
        return numConta;
    }
    public void setNumConta(int numConta){
        this.numConta = numConta;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
   }
    public String getDono() {
       return dono;
   }
    public void setDono(String dono) {
        this.dono = dono;
   }
    public boolean getDebito() {
        return debito;
   }
    public void setDebito(boolean debito) {
        this.debito = debito;
   }
   public boolean getCCredito() {
       return cCredito;
   }
   public void setCCredito(boolean cCredito) {
       this.cCredito = cCredito;
   }
   public int getCredito() {
       return credito;
   }
   public void setCredito(int credito) {
       this.credito = credito;
   }
   public int getFatura() {
       return fatura;
   }
   public void setFatura(int fatura) {
       this.fatura = fatura;
   }
}