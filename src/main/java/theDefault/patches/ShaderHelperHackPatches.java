package theDefault.patches;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.helpers.ShaderHelper;
import com.megacrit.cardcrawl.helpers.ShaderHelper.Shader;

import static theDefault.DefaultMod.AestheticShader;
import static theDefault.DefaultMod.logger;

public class ShaderHelperHackPatches {
    @SpirePatch(clz = ShaderHelper.class, method = "setShader", paramtypez = {SpriteBatch.class, Shader.class})
    public static class SbPatches
    {
        @SpirePrefixPatch
        public static SpireReturn SbPatch(SpriteBatch sb, ShaderHelper.Shader Shader) {
            if (Shader == ShaderHelper.Shader.DEFAULT)
            {
                sb.end();
                sb.setShader(AestheticShader);
                sb.begin();
                return SpireReturn.Return(null);
            }
            return SpireReturn.Continue();
        }
    }
    @SpirePatch(clz = ShaderHelper.class, method = "setShader", paramtypez = {PolygonSpriteBatch.class, Shader.class})
    public static class PsbPatches
    {
        @SpirePrefixPatch
        public static SpireReturn SbPatch(PolygonSpriteBatch sb, ShaderHelper.Shader Shader)
        {
            if (Shader == ShaderHelper.Shader.DEFAULT)
            {
                sb.end();
                sb.setShader(AestheticShader);
                sb.begin();
                return SpireReturn.Return(null);
            }
            return SpireReturn.Continue();
        }
    }

}
