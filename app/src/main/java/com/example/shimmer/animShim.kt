package com.example.shimmer

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier
import java.nio.file.WatchEvent

@Composable
fun anshim(){
    val shimColor= listOf(
        Color.DarkGray.copy(alpha = 0.8f),
        Color.Blue.copy(alpha = 0.2f),
        Color.DarkGray.copy(alpha = 0.8f),


    )
    val transition= rememberInfiniteTransition()
    val translateAnim= transition.animateFloat(
        initialValue =0f
        , targetValue =1000f
        , animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutLinearInEasing

            )/*,
            repeatMode = RepeatMode.Reverse*/
        ) )
    val brush = Brush.linearGradient(
        colors = shimColor,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )
    ShimmerGridItem(brush = brush )

}
@Composable
fun ShimmerGridItem(brush: Brush){
    Row(modifier = androidx.compose.ui.Modifier
        .fillMaxWidth()
        .padding(10.dp),

        verticalAlignment = Alignment.CenterVertically) {
        Spacer(modifier = androidx.compose.ui.Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(brush))
        
        Spacer(modifier = androidx.compose.ui.Modifier
            .padding(
                10.dp
            ))
        Column(verticalArrangement = Arrangement.Center) {
            Spacer(modifier = androidx.compose.ui.Modifier
                .height(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.7f)
                .background(brush))

            Spacer(modifier = androidx.compose.ui.Modifier
                .padding(
                    5.dp
                ))


            Spacer(modifier = androidx.compose.ui.Modifier
                .height(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.9f)
                .background(brush))
        }

    }


}