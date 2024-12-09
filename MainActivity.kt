import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}


@Composable
fun MyApp() {
    Column(
    ) {
        Header()
        RecentActivities()
        AppButton()
    }
}


@Composable
fun RecentActivities() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Recent Activities",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        ActivityRow(
            icon = android.R.drawable.dark_header,
            description = "Committed changes",
            count = 22
        )
        ActivityRow(
            icon = android.R.drawable.dark_header,
            description = "Comment count",
            count = 15
        )
        ActivityRow(
            icon = android.R.drawable.dark_header,
            description = "Merged pull requests",
            count = 8
        )
        ActivityRow(
            icon = android.R.drawable.dark_header,
            description = "Closed pull requests",
            count = 3
        )
    }
}

@Composable
fun ActivityRow(icon: Int, description: String, count: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color(0xFFEDE7F6), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
//            Image(
//                painter = painterResource(id = icon),
//                contentDescription = null,
//                modifier = Modifier.size(24.dp)
//            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            Text(
                text = description,
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        Text(
            text = count.toString(),
            fontSize = 16.sp,
            color = Color(0xFF673AB7),
            fontWeight = FontWeight.Bold
        )
    }
}



@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
//        val icon: Painter = painterResource(id = android.R.drawable.dark_header)
//        Image(
//            painter = icon,
//            contentDescription = "User Icon",
//            modifier = Modifier
//                .size(65.dp)
//                .padding(end = 16.dp)
//        )

        Column {
            Text(
                text = "Alex Żmuda-Trzebiatowski",
                fontSize = 18.sp,
                color = Color.Black
            )
            Text(
                text = "Git statistics",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}


@Composable
fun AppButton() {
    Button(
        onClick = {
            Toast.makeText(context, "Well done", Toast.LENGTH_SHORT).show()
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()


    ) {
        Text(
            text = "Kliknij mnie",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewUserHeader() {
    MyApp()
}