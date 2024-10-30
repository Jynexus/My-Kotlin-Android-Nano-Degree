package com.example.mystore
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI


/**
 * A simple [Fragment] subclass.
 * Use the [StoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StoreFragment : Fragment() {

    private lateinit var  viewModel: StoreViewModel
    private  lateinit var  inflaterThis :LayoutInflater
    private lateinit var viewThis : View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewThis = view
        view.findViewById<Button>(R.id.button_addNew).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_storeFragment_to_newItemFragment)
        }
        val listShoesLinear = view.findViewById<LinearLayout>(R.id.linearLay_shoes)

        viewModel.items.forEach {
            var newViewToAdd : View = inflaterThis.inflate(R.layout.item_new, listShoesLinear, false)
            newViewToAdd.findViewById<TextView>(R.id.textView_name).text = "Name: " + it.name
            newViewToAdd.findViewById<TextView>(R.id.textView_company).text = "Company: " + it.company
            newViewToAdd.findViewById<TextView>(R.id.textView_size).text = "Size: " + it.size
            newViewToAdd.findViewById<TextView>(R.id.textView_color).text = "Color: " + it.color
            newViewToAdd.findViewById<TextView>(R.id.textView_type).text = "Type: " + it.type
            listShoesLinear.addView(newViewToAdd)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    inflater?.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Navigation.findNavController(viewThis).navigate(R.id.action_storeFragment_to_loginFragment)
        viewModel.items.clear()
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflaterThis = inflater

        setHasOptionsMenu(true)
        viewModel = (activity as MainActivity).viewModel

      //  if(arguments?.get("name") != null) {
       //     var args = StoreFragmentArgs.fromBundle(arguments as Bundle)


            //var newToAdd = ViewModelProvider(this).get(NewItem::class.java)
            //newToAdd.name = args.name
            //newToAdd.company = args.company
            //newToAdd.size = args.size
            //newToAdd.color = args.color
            //newToAdd.type = args.type
            //if(!(newToAdd == null || (newToAdd.name == "" && newToAdd.company == "" && newToAdd.color == "" && newToAdd.size == "" && newToAdd.type == "" ))) {
             //   viewModel.items.add(newToAdd)
           // }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store, container, false)
        }
    }
}

