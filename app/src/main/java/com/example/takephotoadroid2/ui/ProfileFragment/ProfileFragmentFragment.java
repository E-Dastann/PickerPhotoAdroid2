package com.example.takephotoadroid2.ui.ProfileFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.takephotoadroid2.R;
import com.example.takephotoadroid2.databinding.FragmentProfileFragmentBinding;


public class ProfileFragmentFragment extends Fragment {
    private FragmentProfileFragmentBinding binding;
     private ActivityResultLauncher<String> addPhoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentProfileFragmentBinding.inflate(LayoutInflater.from(requireActivity()),container,false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addPhoto=registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        binding.addImage.setImageURI(result);
                    }
                }
        );
       binding.addImage.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View view) {
               addPhoto.launch("image/*");

           }
       });

    }

}