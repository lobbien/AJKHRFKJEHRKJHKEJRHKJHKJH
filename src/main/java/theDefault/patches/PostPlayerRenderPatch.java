package theDefault.patches;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.helpers.ShaderHelper;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class PostPlayerRenderPatch {
    @SpirePatch(clz = AbstractPlayer.class, method = "renderPlayerImage")
    public static class RenderMonster {
        @SpirePostfixPatch
        public static void otherpatch(AbstractPlayer __instance, SpriteBatch sb) {
            ShaderHelper.setShader(sb, ShaderHelper.Shader.DEFAULT);
        }
    }
}
