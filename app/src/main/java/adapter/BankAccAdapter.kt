import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.transfer_tech.R
import com.example.transfer_tech.databinding.HomeFragmentBinding
import kredit.BankAcc
import ui.HomeFragmentDirections

class BankAccAdapter : RecyclerView.Adapter<BankAccAdapter.ItemViewHodler>() {

    private var dataset = listOf<BankAcc>()

    fun submitlist(BankACCList: List<BankAcc>) {
        dataset = BankACCList
        notifyDataSetChanged()
    }

    class ItemViewHodler(view: View) : RecyclerView.ViewHolder(view) {

        val bankname = view.findViewById<TextView>(R.id.senderTV)
        val firstname = view.findViewById<TextView>(R.id.transactionIDTV2)
        val lastname = view.findViewById<TextView>(R.id.dateTV2)
        val balance = view.findViewById<TextView>(R.id.amountTV2)
        val currency = view.findViewById<TextView>(R.id.currencyTV)
        val iban = view.findViewById<TextView>(R.id.sender_ibanTV2)
        val bankACCCardview = view.findViewById<CardView>(R.id.turnoversCV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHodler {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.bankacc_item, parent, false)
        return ItemViewHodler(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHodler, position: Int) {

        val bankAccData : BankAcc = dataset[position]

        holder.bankname.text = bankAccData.name
        holder.firstname.text = bankAccData.owner_firstname
        holder.lastname.text = bankAccData.owner_surname
        holder.balance.text = bankAccData.balance
        holder.iban.text = bankAccData.iban
        holder.currency.text = bankAccData.currency
        holder.bankACCCardview.setOnClickListener {
            holder.itemView.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(
            bankAccData.id.toString()
            )
            )
        }

    }

    override fun getItemCount(): Int {
        return  dataset.size
    }
}