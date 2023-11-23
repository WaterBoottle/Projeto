package br.italo.modelos;

public class Pedido {


    private int idPedido;
    private int idCliente;
    private int idProduto;
    private int idPagamento;
    private String dataPedido;
    private String dataDevolucao;


    public int getIdPedido() {
        return idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }


    public Pedido(int idPedido, int idCliente, int idProduto, int idPagamento, String dataPedido, String dataDevolucao) {

        super();

        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.idPagamento = idPagamento;
        this.dataPedido = dataPedido;
        this.dataDevolucao = dataDevolucao;
    }
}