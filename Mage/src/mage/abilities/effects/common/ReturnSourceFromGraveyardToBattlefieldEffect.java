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

package mage.abilities.effects.common;

import mage.constants.Outcome;
import mage.constants.Zone;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.cards.Card;
import mage.game.Game;
import mage.players.Player;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class ReturnSourceFromGraveyardToBattlefieldEffect extends OneShotEffect {

    private boolean tapped;
    private boolean ownerControl;

    public ReturnSourceFromGraveyardToBattlefieldEffect() {
        this(false);
    }

    public ReturnSourceFromGraveyardToBattlefieldEffect(boolean tapped) {
        super(Outcome.PutCreatureInPlay);
        this.tapped = tapped;
        setText();
    }
    public ReturnSourceFromGraveyardToBattlefieldEffect(boolean tapped, boolean ownerControl) {
        super(Outcome.PutCreatureInPlay);
        this.tapped = tapped;
        this.ownerControl = ownerControl;
        setText();
    }

    public ReturnSourceFromGraveyardToBattlefieldEffect(final ReturnSourceFromGraveyardToBattlefieldEffect effect) {
        super(effect);
        this.tapped = effect.tapped;
        this.ownerControl = effect.ownerControl;
    }

    @Override
    public ReturnSourceFromGraveyardToBattlefieldEffect copy() {
        return new ReturnSourceFromGraveyardToBattlefieldEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        if (!game.getState().getZone(source.getSourceId()).equals(Zone.GRAVEYARD)) {
            return false;
        }        
        Card card = game.getCard(source.getSourceId());
        if (card == null) {
            return false;
        }
        
        Player player;   
        if (ownerControl) {
            player = game.getPlayer(card.getOwnerId());
        } else {
            player = game.getPlayer(source.getControllerId());
        }                
        if (player == null) {            
            return false;
        }        
        
        return player.putOntoBattlefieldWithInfo(card, game, Zone.GRAVEYARD, source.getSourceId(), tapped);
    }

    private void setText() {
        StringBuilder sb = new StringBuilder("Return {this} from your graveyard to the battlefield");
        if (tapped) {
            sb.append(" tapped");
        }        
        if (ownerControl) {
               sb.append(" under its owner's control");
        }
        staticText = sb.toString();
    }

}
