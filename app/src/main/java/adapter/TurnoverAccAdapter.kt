package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bankacc.TurnoverAcc
import com.example.transfer_tech.R

class TurnoverAccAdapter : RecyclerView.Adapter<TurnoverAccAdapter.ItemViewHodler>() {

    private var dataset = listOf<TurnoverAcc>()

    fun submitlist(TurnOverAccList: List<TurnoverAcc>) {
        dataset = TurnOverAccList
        notifyDataSetChanged()
    }

    class ItemViewHodler(view: View) : RecyclerView.ViewHolder(view) {

        val senderName = view.findViewById<TextView>(R.id.senderTV)
        val transactionID = view.findViewById<TextView>(R.id.transactionIDTV2)
        val date = view.findViewById<TextView>(R.id.dateTV2)
        val amount = view.findViewById<TextView>(R.id.amountTV2)
        val senderIban = view.findViewById<TextView>(R.id.sender_ibanTV2)
        val reference = view.findViewById<TextView>(R.id.referenceTV2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHodler {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.turnover_item, parent, false)
        return ItemViewHodler(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHodler, position: Int) {

        val senderAccData : TurnoverAcc = dataset[position]

        holder.senderName.text = senderAccData.sender_name
        holder.transactionID.text = senderAccData.id
        holder.date.text = senderAccData.date
        holder.amount.text = senderAccData.amount.toString()
        holder.senderIban.text = senderAccData.sender_iban
        holder.reference.text = senderAccData.reference

    }

    override fun getItemCount(): Int {
        return  dataset.size
    }
}