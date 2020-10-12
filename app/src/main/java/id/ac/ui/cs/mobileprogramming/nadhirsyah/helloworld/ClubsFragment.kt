package id.ac.ui.cs.mobileprogramming.nadhirsyah.helloworld

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class ClubsFragment : Fragment() {

    companion object {
        fun newInstance() = ClubsFragment()
    }

    private lateinit var viewModel: ClubsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel= ViewModelProviders.of(activity!!).get(ClubsViewModel::class.java)
        val rootView: View = inflater.inflate(R.layout.clubs_fragment, container, false)
        val clubView: TextView = rootView.findViewById(R.id.clubs_details_name)
        val clubDetailView: TextView = rootView.findViewById(R.id.clubs_details_content)
        clubView.setText(viewModel.club.toString())
        clubDetailView.setText(viewModel.clubDetail.toString())
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ClubsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}