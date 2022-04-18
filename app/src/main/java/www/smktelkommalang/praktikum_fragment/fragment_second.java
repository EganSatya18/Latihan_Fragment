package www.smktelkommalang.praktikum_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class fragment_second extends Fragment {
    private PageViewModel pageViewModel;
    private TextView txtName;

    public fragment_second() {
        // Required empty public constructor
    }

    public static fragment_second newInstance() {
        return new fragment_second();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtName = view.findViewById(R.id.textView2);

        pageViewModel.getName().observe(requireActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        txtName.setText(s);
                    }
                }
        );
    }
}