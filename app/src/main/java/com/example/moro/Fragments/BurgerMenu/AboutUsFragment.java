package com.example.moro.Fragments.BurgerMenu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.moro.Fragments.CustomFragment;
import com.example.moro.R;
/**
 * @author Mikkel Johansen s175194
 */
public class AboutUsFragment extends CustomFragment {

    public AboutUsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about_us, container, false);

        TextView aboutUsTxt = v.findViewById(R.id.aboutText);
        Button catchUs = v.findViewById(R.id.menu_catchushere);

        //adds an onClick listener to our button
        catchUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ContactFragment());
            }
        });
        aboutUsTxt.setText("Vi er MORO. \n" +
                "\n" +
                "Otte unge kvinder, der er fyldt med passion, gåpåmod og skabertrang! Vi kommer fra vidt forskellige steder i landet og har vidt forskellige baggrunde, men er gået sammen om et fælles projekt - et projekt vi kalder MORO.\n" +
                "\n" +
                "Skabt af unge, til unge.\n" +
                "Vi blev i første omgang samlet om kærligheden til kulturen gennem et ophold på Roskilde\n" +
                "Festival Højskole, hvor vi var en del af første årgang. Efter et halvt års samarbejde om at skabe\n" +
                "kulturelle oplevelser for unge mennesker opstod idéen:\n" +
                "\n" +
                "En platform for unge og andre interesserede, hvor alle store som små oplevelser og begivenheder bliver samlet og fremlagt på en overskuelig, navigerbar og ikke mindst inspirerende måde - om det så\n" +
                "drejer sig om loppemarkeder, kunst-talks eller silent disco-fester.\n" +
                "\n" +
                "MORO er et online kulturfællesskab, der inspirerer unge til at opleve nye sider af kulturen, og\n" +
                "danner ramme om nye sociale fællesskaber i København. Vi vil give dig en skræddersyet oversigt over byens mange arrangementer og ambitionen er, at MORO bliver dit go-to redskab, når weekenden, daten eller bare onsdagen skal planlægges.\n" +
                "\n" +
                "Vi ønsker at udbrede brugen af kulturlivet blandt unge og inspirere unge til at udvide deres kulturelle horisont. Det behøver ikke at vælte budgettet at leve et oplevelsesrigt og kulturelt liv, og man behøver ikke på forhånd have stort kendskab til kunst, kultur og musik. \n" +
                "\n" +
                "Vi elsker at få oplevelser sammen om kulturen, og det ønsker vi at udbrede. Med MORO skal vi opleve kulturen sammen og at styrke diversiteten i kulturen.");

        return v;
    }
}