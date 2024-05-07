package br.com.fiap.listadecompra

    /**
     * Um modelo de dados para representar um item na lista.
     * Esta classe é uma data class, o que significa que é usada principalmente para armazenar dados.
     *  Uma classe de dados no Kotlin automaticamente fornece métodos como equals(), hashCode(), toString(), entre outros, com base nas propriedades declaradas na classe.
     *
     * Este modelo contém uma única propriedade, o nome do item.
     * @property name O nome do item.
     */
    data class ItemModel(val name: String)

