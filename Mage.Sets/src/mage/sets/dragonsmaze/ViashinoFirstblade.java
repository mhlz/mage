/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.dragonsmaze;

import java.util.UUID;
import mage.Constants.CardType;
import mage.Constants.Duration;
import mage.Constants.Rarity;
import mage.MageInt;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.effects.common.continious.BoostSourceEffect;
import mage.abilities.keyword.HasteAbility;
import mage.cards.CardImpl;

/**
 *
 * @author jeffwadsworth
 */
public class ViashinoFirstblade extends CardImpl<ViashinoFirstblade> {

    public ViashinoFirstblade(UUID ownerId) {
        super(ownerId, 113, "Viashino Firstblade", Rarity.COMMON, new CardType[]{CardType.CREATURE}, "{1}{R}{W}");
        this.expansionSetCode = "DGM";
        this.subtype.add("Viashino");
        this.subtype.add("Soldier");

        this.color.setRed(true);
        this.color.setWhite(true);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // Haste
        this.addAbility(HasteAbility.getInstance());
        
        // When Viashino Firstblade enters the battlefield, it gets +2/+2 until end of turn.
        this.addAbility(new EntersBattlefieldTriggeredAbility(new BoostSourceEffect(2, 2, Duration.EndOfTurn)));
    }

    public ViashinoFirstblade(final ViashinoFirstblade card) {
        super(card);
    }

    @Override
    public ViashinoFirstblade copy() {
        return new ViashinoFirstblade(this);
    }
}