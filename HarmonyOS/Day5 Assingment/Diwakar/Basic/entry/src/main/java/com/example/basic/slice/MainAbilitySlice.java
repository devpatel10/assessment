package com.example.basic.slice;

import com.example.basic.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.animation.AnimatorProperty;
import ohos.agp.components.Button;
import ohos.agp.components.Image;

public class MainAbilitySlice extends AbilitySlice {


    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);


        Button login_btn, signUp_btn;

        login_btn = (Button)findComponentById(ResourceTable.Id_login_btn);
        signUp_btn = (Button)findComponentById(ResourceTable.Id_signUp_btn);

        login_btn.setClickedListener(listener->present(new LoginSlice(),new Intent()));
        signUp_btn.setClickedListener(listener->present(new SignUpSlice(),new Intent()));

        Image image = (Image)findComponentById(ResourceTable.Id_image_dp);

        AnimatorProperty imageAnimation = image.createAnimatorProperty();
        imageAnimation.setDuration(2000).rotate(360).setLoopedCount(2);


        image.setClickedListener(component -> imageAnimation.start());

    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
