package com.example.bankingappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import com.example.bankingappui.data.Card
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingappui.ui.theme.BlueEnd
import com.example.bankingappui.ui.theme.BlueStart
import com.example.bankingappui.ui.theme.OrangeEnd
import com.example.bankingappui.ui.theme.OrangeStart
import com.example.bankingappui.ui.theme.PurpleEnd
import com.example.bankingappui.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "Visa",
        cardNumber = "3344 5566 7788 1234",
        cardName = "Business Card",
        balance = 100.24,
        color = getGradient( PurpleStart, PurpleEnd )),
    Card(
        cardType = "MasterCard",
        cardNumber = "1234 6666 3333 1111",
        cardName = "Saving Card",
        balance = 560.64,
        color = getGradient( BlueStart, BlueEnd )),
    Card(
        cardType = "Visa",
        cardNumber = "5555 4444 3433 2222",
        cardName = "Credit Card",
        balance = 1503.00,
        color = getGradient(OrangeStart, OrangeEnd )),
    Card(
        cardType = "MasterCard",
        cardNumber = "7675 2354 1246 9875",
        cardName = "Deposit Card",
        balance = 5000.26,
        color = getGradient(OrangeStart, OrangeEnd ))
)

fun getGradient(
    startColor : Color,
    endColor: Color
) : Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}
@Preview
@Composable
fun CardSection (){
    LazyRow{
        items(cards.size){ index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index : Int
){
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cards.size - 1){
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(R.drawable.visa)
    if(card.cardType == "MasterCard"){
        image = painterResource(R.drawable.ms)
    }
    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column(
            Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )

            Spacer (modifier = Modifier.height(10.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}






