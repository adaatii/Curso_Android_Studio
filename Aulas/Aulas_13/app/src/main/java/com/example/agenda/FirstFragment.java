package com.example.agenda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.agenda.databinding.FragmentFirstBinding;

import android.util.Log;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.v("CFB", "aplicativo iniciado");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.v("CFB", "aplicativo retomado");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.v("CFB", "aplicativo pausado");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.v("CFB", "aplicativo parado");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.v("CFB", "aplicativo destruido");
    }

}