import { NumberSymbol } from "@angular/common";

export class CharacterAttributes {

    static increaseAttribute(actualValue: number, maximumValue: number, px: number): number[] {

        let startValue: number = actualValue;
        let pxCost: number = (actualValue + 1) * 2;
        let maximumPxCost: number = maximumValue * 2;

        if(px < pxCost) {
            alert("you don't have enought px");
            return [startValue, px];
        }else{
            if(pxCost > maximumPxCost) {
                pxCost = maximumPxCost;
            }
    
            if(actualValue + 1 > maximumValue) {
                alert("maximum attribute value is 10")
                return [startValue, px];
            }else{
                actualValue++;
                return [actualValue, px - pxCost];
            }
        }        
    }
    static decreaseAttribute(actualValue: number, minimumValue: number, px: number): number[] {

        let newValue = actualValue - 1;
        let pxCost = actualValue * 2;

        if (newValue < minimumValue) {
            alert(`Attributes can't be lower than ${minimumValue}`);
            actualValue = minimumValue;
            return [actualValue, px];
        } else {
            px = px + pxCost;
            actualValue--;
            return [actualValue, px];
        }

    }
}
