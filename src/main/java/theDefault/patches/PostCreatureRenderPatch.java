package theDefault.patches;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ShaderHelper;
import com.megacrit.cardcrawl.monsters.AbstractMonster;


public class PostCreatureRenderPatch {
    @SpirePatch(clz = AbstractMonster.class, method = "render")
    public static class RenderMonster {
        @SpirePostfixPatch
        public static void otherpatch(AbstractMonster __instance, SpriteBatch sb) {
            ShaderHelper.setShader(sb, ShaderHelper.Shader.DEFAULT);
        }
    }
}