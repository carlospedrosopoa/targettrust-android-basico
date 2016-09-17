package br.com.targettrust.fragments.example0;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.com.suelengc.devfest.R;

public class Fragment2 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment2, null);
		TextView text = (TextView) view.findViewById(R.id.text2);
		text.setText("Fragment 2");
		return view;
	}

	public void setTexto(String mensagem) {
		TextView text = (TextView) getView().findViewById(R.id.text2);
		text.setText(mensagem);	
		
//		Fragment3 frag3 = (Fragment3) getFragmentManager().findFragmentById(R.id.frag3);
//		frag3.setTexto(mensagem);
		
		getActivity().setTitle("Mudando o texto a partir do Fragment");
	}

}
