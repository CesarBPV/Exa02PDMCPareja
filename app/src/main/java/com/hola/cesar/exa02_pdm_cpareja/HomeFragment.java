package com.hola.cesar.exa02_pdm_cpareja;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageView miv1,miv2,miv3,miv4;
    LinearLayout item_clothes,item_shoes,item_accessories,item_offers,item_news;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_home, container, false);
        miv1=view.findViewById(R.id.iv1);
        miv2=view.findViewById(R.id.iv2);
        miv3=view.findViewById(R.id.iv3);
        miv4=view.findViewById(R.id.iv4);
        item_clothes=view.findViewById(R.id.item_clothes);
        item_shoes=view.findViewById(R.id.item_shoes);
        item_accessories=view.findViewById(R.id.item_accesories);
        item_offers=view.findViewById(R.id.item_offers);
        item_news=view.findViewById(R.id.item_news);
        item_clothes.setOnClickListener(this);
        item_shoes.setOnClickListener(this);
        item_accessories.setOnClickListener(this);
        item_offers.setOnClickListener(this);
        item_news.setOnClickListener(this);
        Picasso.with(getContext()).load("https://dexter.vteximg.com.br/arquivos/ids/334216-540-540/ADBA8151_1.jpg?v=636504984433800000").into(miv1);
        Picasso.with(getContext()).load("https://greenglobaltravel.com/wp-content/uploads/2017/06/Best-Travel-Clothes-Oros-Apparel-Rover-Jacket.jpg").into(miv2);
        Picasso.with(getContext()).load("https://www.ardene.com/dw/image/v2/BBVB_PRD/on/demandware.static/-/Sites-master-catalog/default/dw1741d448/images/large/8A-WL00287-f7d10f78-cbee-4f52-a9a1-b8b009d833a2.jpg?sw=265&sh=398&sm=fit").into(miv3);
        Picasso.with(getContext()).load("https://gloimg.zafcdn.com/zaful/pdm-product-pic/Clothing/2017/08/15/grid-img/1510288174822833935.jpg").into(miv4);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        Fragment fragment=null;
        switch(view.getId()){
            case R.id.item_accesories:
                fragment=AccesoriesFragment.newInstance("1","accessories");
                break;
            case R.id.item_clothes:
                fragment=ClothesFragment.newInstance("1","clothes");
                break;
            case R.id.item_news:
                fragment=NewsFragment.newInstance("1","news");
                break;
            case R.id.item_offers:
                fragment=OffersFragment.newInstance("1","offers");
                break;
            case R.id.item_shoes:
                fragment=ShoesFragment.newInstance("1","shoes");
                break;
        }
        FragmentManager fragmentManager=getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flcontent,fragment).commit();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
