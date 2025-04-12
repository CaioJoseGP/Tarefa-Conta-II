public class ContaCorrente {
    private double saldo;
    private String numero;
    private String agencia;
    private String banco;
    private Titular titularPrimario;
    //private Titular titularSecundario;

    public ContaCorrente(String numero, String banco, Titular titular) {
        this.saldo = 0.0;
        this.numero = numero;
        this.agencia = "";
        this.banco = banco;
        this.titularPrimario = titular;
    }

    public ContaCorrente(double saldo, String numero, String agencia, String banco, Titular titular) {
        this.saldo = saldo;
        this.numero = numero;
        this.agencia = agencia;
        this.banco = banco;
        this.titularPrimario = titular;
    }

    // public ContaCorrente(String numero, String banco, String agencia, Titular titularPrimario, Titular titularSecundario) {
    //     this.saldo = 0.0;
    //     this.numero = numero;
    //     this.agencia = agencia;
    //     this.banco = banco;
    //     this.titularPrimario = titularPrimario;
    //     this.titularSecundario = titularSecundario;
    // }

    public boolean depositar(double valor) {
        if(valor <= 0) {
            return false;

        } else {
            this.saldo = this.saldo + valor;
            return true;
        }
    }

    public boolean sacar(double valor) {
        if(this.saldo < valor || valor <= 0) {
            return false;

        } else {
            this.saldo = this.saldo - valor;
            return true;
        }
    }
    
    public boolean transferir(double valor, ContaCorrente contaTransferencia) {
        if(this.saldo < valor || valor <= 0) {
            return false;

        } else {
            contaTransferencia.saldo = contaTransferencia.saldo + valor;
            this.saldo = this.saldo - valor;
            return true;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTitularPrimario() {
        return titularPrimario.getNome();
    }

    // public String getTitularSecundario() {
    //     return titularSecundario.getNome();
    // }

    public void extrato() {
        System.out.println("\n\nExtrato Bancário Completo\n"
            + "\nNúmero da Conta: " + this.numero
            + "\nTitular: " + this.titularPrimario.getNome()
            + "\nSaldo: " + this.saldo);
    }
}