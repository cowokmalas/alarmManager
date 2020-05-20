package com.example.myalarmmanager.fragment


import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment

import com.example.myalarmmanager.R
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class DatePickerFragment : DialogFragment(),DatePickerDialog.OnDateSetListener {
    interface DialogDateListener {
        fun onDialogDateSet(tag:String?,year: Int,month:Int,dayOfMonth: Int)
    }

    private var mListener:DialogDateListener?=null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context!=null){
            mListener =context as DialogDateListener?
        }
    }

    override fun onDetach() {
        super.onDetach()
        if (mListener!=null){
            mListener=null
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar= Calendar.getInstance()
        val year=calendar.get(Calendar.YEAR)
        val month=calendar.get(Calendar.MONTH)
        val date=calendar.get(Calendar.DATE)

        return DatePickerDialog(activity as Context,this,year,month,date)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        mListener?.onDialogDateSet(tag,year,month,dayOfMonth)
    }

}
