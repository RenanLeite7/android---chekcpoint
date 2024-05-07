package br.com.fiap.listadecompra

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.listaprodutos.R

/**
 * Um adaptador personalizado para exibir uma lista de itens em um RecyclerView.
 *
 * Este adaptador é responsável por fornecer os itens para exibição e criar os ViewHolder necessários para a exibição dos itens.
 */
class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {


    /**
     * @property items A lista mutável de ItemModel contendo os itens a serem exibidos.
     *
     * mutableListOf: É uma função que cria uma lista mutável, ou seja, uma lista na qual você pode adicionar, remover e modificar elementos após sua criação.
     * Essa função é útil quando você precisa de uma lista que possa ser alterada.
     * <ItemModel>: É tipo de objeto que a lista pode conter, neste caso
     */
    private val items = mutableListOf<ItemModel>()

    /**
     * Adiciona um novo item à lista e notifica o RecyclerView da mudança.
     * @param newItem O novo item a ser adicionado.
     *
     * notifyDataSetChanged(): Este método notifica o adaptador associado à exibição (como um RecyclerView.Adapter) de que os dados mudaram, e ele precisa atualizar a exibição para refletir essas mudanças.
     * Ele informa à RecyclerView que houve uma alteração nos dados e que ela precisa recriar e atualizar as visualizações dos itens de acordo com os dados atualizados.
     *
     */
    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }

    /**
     * Método  chamado pelo RecyclerView quando precisa criar um novo ViewHolder para exibir um item da lista.
     *
     * @param parent O ViewGroup no qual o novo View será inflado.
     * @param viewType O tipo de view que será inflada.
     * @param view Infla o layout do item a partir do arquivo XML e cria uma nova visualização.
     * @return retorna uma nova instância do ViewHolder que contém a visualização inflada do item de lista.
     * O ViewHolder é responsável por manter referências às visualizações do item e permitir o acesso eficiente a elas durante a rolagem da lista.
     *  Essa instância de ViewHolder é então retornada pelo método onCreateViewHolder() para ser usada pelo RecyclerView.
     *
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }


    /**
     * Método chamado pelo RecyclerView para exibir os dados em uma posição específica.
     * Os dados do produto na posição específica são vinculados aos elementos de visualização correspondentes no ViewHolder.
     * @param holder O ViewHolder a ser atualizado com os dados do item na posição fornecida no conjunto de dados.
     * @param position A posição do item na lista.
     * @param item Obtém o item na posição especificada no conjunto de dados, 'items' é a lista que contém os dados a serem exibidos na RecyclerView.
     * holder.bind(item): Este método bind(item) é chamado no ViewHolder para vincular os dados do item à visualização representada por ele.
     *  É responsável por atualizar as visualizações dentro do ViewHolder com os dados do item.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    /**
   Método retorna o número total de itens na lista de produtos.
   */
    override fun getItemCount(): Int = items.size


    /**
     * ViewHolder personalizado para exibir cada item na RecyclerView.
     * @param view A view que contém o item.
     */
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        /**
         * TextView para exibir o nome do item.
         */
        val textView = view.findViewById<TextView>(R.id.textViewItem)

        /**
         * Atualiza a TextView com os dados do item.
         * @param item O item a ser exibido.
         */

        fun bind(item: ItemModel) {
            textView.text = item.name
        }
    }

}