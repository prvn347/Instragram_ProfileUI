package com.example.instragram_profileui

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontSynthesis.Companion.Weight
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
TopBar(name = "prvn347")
        Spacer(modifier = Modifier.height(8.dp))
        ProfileDescription()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection()
        Spacer(modifier = Modifier.height(25.dp))
highlightSection(highlights = listOf(
    Storyhighlights(image = painterResource(id =R.drawable.my ), text = "Farewell"),
    Storyhighlights(image = painterResource(id = R.drawable.spidey), text = "SMATM")

), modifier = Modifier
    .fillMaxWidth()
    .padding(horizontal = 16.dp))

    Spacer(modifier = Modifier.height(10.dp))
    PostTabView(imagewithText  = listOf(
        Storyhighlights(image = painterResource(id = R.drawable.ic_grid), text = "Post"),
        Storyhighlights(image = painterResource(id = R.drawable.ic_reels), text = "Reels"),
        Storyhighlights(image = painterResource(id = R.drawable.ic_igtv), text = "IGTV"),
        Storyhighlights(image = painterResource(id = R.drawable.profile), text = "Profile")
    )){
        selectedTabIndex = it
    }
    when(selectedTabIndex){
        0 -> Post(Post = listOf(
            painterResource(id = R.drawable.my2),
            painterResource(id = R.drawable.randome),
            painterResource(id = R.drawable.polar),
            painterResource(id = R.drawable.randome12),
            painterResource(id = R.drawable.my),
        ), modifier = Modifier.fillMaxWidth())
    }
    }

    
}

@Composable
fun TopBar(name:String,modifier:Modifier = Modifier) {

    Row(modifier = modifier
        .fillMaxWidth()
      , verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround) {

        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "backarrow", tint = Color.Black, modifier = modifier.size(24.dp))
        Text(text = name
        , overflow = TextOverflow.Ellipsis, fontWeight = FontWeight.Bold, fontSize = 20.sp
        )
        Icon(painter = painterResource(id = R.drawable.ic_bell), contentDescription = "backarrow", tint = Color.Black, modifier = modifier.size(24.dp))
        Icon(painter = painterResource(id = R.drawable.ic_dotmenu) , contentDescription = "Settings", tint = Color.Black, modifier = modifier.size(20.dp))

    }
}

@Composable
fun ProfileDescription(modifier: Modifier= Modifier) {
    Column(modifier = modifier
        .fillMaxWidth()
        ) {
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
            RoundImage(image= painterResource(R.drawable.my),modifier = modifier
                .size(100.dp)
                .weight(1f)
                )
                Spacer(modifier = modifier.height(16.dp))
            StatSection(modifier = modifier.weight(7f))

        }
        Spacer(modifier = modifier.height(12.dp))
        ProfileDescriptions(
            ProfileName = "Pravin Sahu",
            ProfileDescription = "Android Expert | Video Editor | Jetpack Compose | Ex-Intern @WhooshEntertainment",
            url = "prvn347.linktre",
            followedBy = listOf("Vrihas Pathak","Jasmine Kispotta"),
            otherCount =34
        )

    }


}

@Composable
fun RoundImage(image:Painter,modifier: Modifier = Modifier)
{
    Image(painter = image, contentDescription = null,modifier = modifier
        .border(width = 2.dp, color = Color.LightGray, shape = CircleShape)
        .aspectRatio(1f, matchHeightConstraintsFirst = true)
        .padding(2.dp)
        .clip(
            CircleShape
        ))

}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement =Arrangement.SpaceAround) {

        DescriptionStat(nameText = "20", name ="Post")

        DescriptionStat(nameText = "200K", name ="Followers" )
        DescriptionStat(nameText = "256", name ="Following" )
    }

}

@Composable
fun DescriptionStat(nameText: String,modifier: Modifier = Modifier,name: String) {
    Column( verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(4.dp)) {
        Text(text = nameText, fontWeight = FontWeight.Bold, fontSize = 20.sp,)
        Spacer(modifier = modifier.height(4.dp))
        Text(text = name)

    }

}

@Composable
fun ProfileDescriptions(ProfileName:String,ProfileDescription:String,url:String,followedBy:List<String>,otherCount:Int) {
    val spacing = 0.5.sp
    val lineheight = 20.sp
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 30.dp)) {
        Text(text =ProfileName, fontWeight = FontWeight.Bold, letterSpacing =  spacing, lineHeight = lineheight)
        Text(text =ProfileDescription, letterSpacing =  spacing, lineHeight = lineheight)
        Text(text =url, letterSpacing =  spacing, lineHeight = lineheight, color = Color.Blue)
        if (followedBy.isNotEmpty()){
            Text(text = buildAnnotatedString {
                val boldstyle = SpanStyle(
                  fontWeight = FontWeight.Bold, color = Color.Black
                )
                append("Followed by ")
                followedBy.forEachIndexed { index, name ->
                    pushStyle(boldstyle)
                    append(name)
                    pop()
                    if (index < followedBy.size -1){
                        append(", ")
                    }
                }
                    if (otherCount > 2){
                        append(" and")
pushStyle(boldstyle )
                        append(" $otherCount others")
                    }




            }, lineHeight = lineheight, letterSpacing = spacing)
        }



        
    }

}

@Composable
fun ButtonSection(modifier: Modifier = Modifier) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.padding(start = 20.dp).padding(end = 50.dp)
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .size(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(start = 8.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if(text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if(icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }

}

@Composable
fun highlightSection(modifier: Modifier = Modifier,highlights:List<Storyhighlights>) {
    LazyRow(modifier = modifier){
        items(highlights.size){Column(modifier = modifier
            .fillMaxWidth()
            .padding(end = 2.dp), horizontalAlignment = Alignment.CenterHorizontally) {

            RoundImage(image = highlights[it].image, modifier = Modifier.size(70.dp))
            Text(
                text = highlights[it].text,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
        }
    }

}

@Composable
fun PostTabView(modifier: Modifier = Modifier,imagewithText:List<Storyhighlights>,onTabSelected:(selecteIndex:Int)->Unit) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
val inactivecolor =Color.Gray
        TabRow(selectedTabIndex = selectedTabIndex, contentColor = Color.Black, modifier = modifier.background(Color.Transparent)) {
            imagewithText.forEachIndexed { index, item ->
                Tab(selected = selectedTabIndex == index, selectedContentColor = Color.Black, unselectedContentColor = inactivecolor , onClick = { /*
            */
                    selectedTabIndex = index
                    onTabSelected(index)}) {
                    androidx.compose.material3.Icon(
                        painter = item.image,
                        contentDescription = item.text, tint = if (selectedTabIndex == index ) Color.Black else inactivecolor, modifier = Modifier

                            .padding(1.dp).size(20.dp)
                    )


                }

            }
            }

}

@Composable
fun Post( Post: List<Painter>,modifier: Modifier = Modifier) {
    
    LazyVerticalGrid(columns = GridCells.Fixed(3),modifier = modifier.scale(1.01f) ){
        items(Post.size){
            Image(painter = Post[it], contentDescription =null,modifier = modifier
                .aspectRatio(1f)
                .border(width = 1.dp, color = Color.White), contentScale = ContentScale.Crop )
        }
    }
}
@Preview
@Composable
fun SimpleComposablePreview() {
    ProfileScreen()
}