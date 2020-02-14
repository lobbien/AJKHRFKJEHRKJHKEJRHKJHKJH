package theDefault.patches;

import basemod.ReflectionHacks;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.patcher.PatchingException;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import javassist.CannotCompileException;
import javassist.CtBehavior;

import java.util.ArrayList;

import static theDefault.DefaultMod.AestheticShader;

@SpirePatch(clz = CardCrawlGame.class, method = "render")
public class InitializeShaderPatch {
    @SpirePrefixPatch
    public static void patch(CardCrawlGame __instance) {
        SpriteBatch Sb = (SpriteBatch) ReflectionHacks.getPrivate(__instance, CardCrawlGame.class, "sb");
        Sb.setShader(AestheticShader);
        CardCrawlGame.psb.setShader(AestheticShader);
    }
}
