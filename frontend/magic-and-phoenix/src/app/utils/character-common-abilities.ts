export class CharacterCommonAbilities {

static increaseCommonAbility(actualValue: number, maximumValue: number, px: number): number[] {

        let startValue: number = actualValue;
        let pxCost: number = actualValue + 1;
        let maximumPxCost: number = maximumValue * 2;

        if(px < pxCost) {
            alert("you don't have enought px");
            return [startValue, px];
        }else{
            if(pxCost > maximumPxCost) {
                pxCost = maximumPxCost;
            }
    
            if(actualValue + 1 > maximumValue) {
                alert(`maximum Common Ability value is ${maximumValue}`)
                return [startValue, px];
            }else{
                actualValue++;
                return [actualValue, px - pxCost];
            }
        }        
    }
    static decreaseCommonAbility(actualValue: number, minimumValue: number, px: number): number[] {

        let newValue = actualValue - 1;
        let pxCost = actualValue;

        if (newValue < minimumValue) {
            alert(`Common Abilities can't be lower than ${minimumValue}`);
            actualValue = minimumValue;
            return [actualValue, px];
        } else {
            px = px + pxCost;
            actualValue--;
            return [actualValue, px];
        }

    }

}


