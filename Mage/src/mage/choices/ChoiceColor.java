/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
*/

package mage.choices;

import mage.ObjectColor;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class ChoiceColor extends ChoiceImpl {

    public ChoiceColor() {
        super(true);
        this.choices.add("Black");
        this.choices.add("Blue");
        this.choices.add("Green");
        this.choices.add("Red");
        this.choices.add("White");
        this.message = "Choose color";
    }

    public ChoiceColor(final ChoiceColor choice) {
        super(choice);
    }

    @Override
    public ChoiceColor copy() {
        return new ChoiceColor(this);
    }

    public ObjectColor getColor() {
        ObjectColor color = new ObjectColor();
        switch (choice) {
            case "Black":
                color.setBlack(true);
                break;
            case "Blue":
                color.setBlue(true);
                break;
            case "Green":
                color.setGreen(true);
                break;
            case "Red":
                color.setRed(true);
                break;
            case "White":
                color.setWhite(true);
                break;
        }
        return color;
    }

}
