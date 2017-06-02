package com.mobileprogramming.luxuryescort.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.mobileprogramming.luxuryescort.R;
import com.mobileprogramming.luxuryescort.dao.EscortsDAO;
import com.mobileprogramming.luxuryescort.model.Escorts;

/**
 * Created by italo on 17/05/2017.
 */

public class FragmentEscortsRegister extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_escorts_register, container, false);

        final EditText mEditTextName = (EditText) view.findViewById(R.id.editTextName);
        final EditText mEditTextInformation = (EditText) view.findViewById(R.id.editTextInformation);
        final EditText mEditTextPhone = (EditText) view.findViewById(R.id.editTextPhone);
        final EditText mEditTextAge = (EditText) view.findViewById(R.id.editTextAge);
        final EditText mEditTextLocation = (EditText) view.findViewById(R.id.editTextLocation);

        TextView mTextViewUploadPhoto = (TextView) view.findViewById(R.id.textViewUploadPhoto);

        final Switch mSwitchStatus = (Switch) view.findViewById(R.id.switchStatus);

        Button mButtonLocationEscort = (Button) view.findViewById(R.id.buttonLocationEscort);
        Button mButtonSaveEscort = (Button) view.findViewById(R.id.buttonSaveEscort);

        ImageView mImageViewPhoto = (ImageView) view.findViewById(R.id.imageViewPhoto);

        mButtonSaveEscort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EscortsDAO mEscortDAO = new EscortsDAO(getActivity());
                Escorts mEscort = new Escorts();

                mEscort.setmName(mEditTextName.getText().toString());
                mEscort.setmInformation(mEditTextInformation.getText().toString());
                mEscort.setmContact(mEditTextPhone.getText().toString());
                mEscort.setmAge(mEditTextAge.getText().toString());
                mEscort.setmLocation(mEditTextLocation.getText().toString());

                /*mEscortDAO.insert(mEscort);
                OnRefreshFormOK activity = (OnRefreshFormOK) getActivity();
                activity.refresh();

                if (!isLandScape())
                    getActivity().finish();
                Toast.makeText(getActivity(),"Usuário inserido com sucesso!", Toast.LENGTH_SHORT).show();

            }
        });

        Bundle bundle = getArguments();
        if (bundle != null) {
            Escorts student = (Escorts) bundle.getSerializable("escort");
            //carregar nome
            etName.setText(student.getName());
            etEmail.setText(student.getEmail());
            etPhone.setText(student.getPhone());
            //carregar email
            //carregar telefone
        } */

                //return view;
            }

        });
        return view;
    }
}
