package com.example.mystore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.lifecycle.get
import com.example.mystore.databinding.FragmentNewItemBinding

/**
 * A simple [Fragment] subclass.
 * Use the [NewItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewItemFragment : Fragment() {

   // private lateinit var edit_name : EditText
   // private lateinit var edit_company : EditText
   // private lateinit var edit_size : EditText
   // private lateinit var edit_color : EditText
    // private lateinit var edit_type : EditText

    lateinit var binding : FragmentNewItemBinding
    private lateinit var  viewModel: StoreViewModel

    private var newModel = NewItem()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //edit_name = view.findViewById<EditText>(R.id.editText_itemName)
        //edit_company = view.findViewById<EditText>(R.id.editText_itemCompany)
        //edit_size = view.findViewById<EditText>(R.id.editText_itemSize)
        //edit_color = view.findViewById<EditText>(R.id.editText_itemColor)
        //edit_type = view.findViewById<EditText>(R.id.editText_itemType)

        view.findViewById<Button>(R.id.button_Cancel).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_newItemFragment_to_storeFragment)
        }
        view.findViewById<Button>(R.id.button_Add).setOnClickListener {


                viewModel.items.add(newModel)

            Navigation.findNavController(view).navigate((R.id.action_newItemFragment_to_storeFragment))
               //.navigate(NewItemFragmentDirections.actionNewItemFragmentToStoreFragment(newModel.name,newModel.company,newModel.size,newModel.color,newModel.type))
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = (activity as MainActivity).viewModel

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_new_item,container,false)
        binding.newModel = newModel
        // Inflate the layout for this fragment
        return binding.root
    }

}