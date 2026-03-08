# Finance App

A modern Android finance application built with Jetpack Compose, featuring an intuitive UI for managing cards, finance categories, and live currency exchange rates.

---

## Screenshots

> Home screen showing card carousel, finance shortcuts, and the collapsible currency exchange table.

---

## Features

- **Card Carousel** — Horizontally scrollable card list using `LazyRow`, displaying Visa and Mastercard cards with balance and masked card numbers.
- **Finance Shortcuts** — Quick-access tiles (My Business, My Wallet, Finance Analytics) rendered in a horizontal `LazyRow`.
- **Currencies Section** — Expandable/collapsible panel with smooth `animateContentSize` animation, listing buy/sell rates for USD, YEN, LIRA, RUPEE, and RUBLE.
- **Bottom Navigation Bar** — Tabs for Home, Wallet, Notifications, and Account.
- **Balance Header** — Displays total balance with a search action button.

---

## Tech Stack

| Layer | Technology |
|---|---|
| UI Framework | Jetpack Compose |
| Scrollable Lists | `LazyColumn`, `LazyRow` |
| Animation | `animateContentSize` |
| Language | Kotlin |

---

## UI Structure

```
LazyColumn (main screen scroll)
│
├── Header — Balance + Search icon
│
├── LazyRow — Card carousel (Visa, Mastercard, ...)
│
├── Section: Finance
│   └── LazyRow — Shortcut tiles (My Business, My Wallet, Finance Analytics)
│
└── CurrenciesSection  ← Expandable with animateContentSize
    ├── Row: Arrow icon button + "Currencies" title
    ├── Divider
    └── if (isVisible):
        └── BoxWithConstraints
            └── Column
                ├── Header row: Currency | Buy | Sell
                └── LazyColumn → CurrencyItem × 5
```

---

## Currencies Section — Expand/Collapse

The section uses `animateContentSize()` on the parent `Column` and a boolean state to show/hide the currency table. The toggle arrow icon updates alongside the visibility state.

```kotlin
var isVisible by remember { mutableStateOf(false) }
var iconState by remember { mutableStateOf(Icons.Rounded.KeyboardArrowDown) }

Column(
    modifier = Modifier
        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
        .background(MaterialTheme.colorScheme.inverseOnSurface)
        .animateContentSize()
) {
    // Toggle button
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .clickable {
                isVisible = !isVisible
                iconState = if (isVisible) Icons.Rounded.KeyboardArrowUp
                            else Icons.Rounded.KeyboardArrowDown
            }
    ) {
        Icon(imageVector = iconState, contentDescription = "Currencies")
    }

    // Animated content
    if (isVisible) {
        // Currency table rendered here
    }
}
```

---

## Responsive Column Layout with BoxWithConstraints

The currency table columns (Currency, Buy, Sell) are sized dynamically by dividing the available width into thirds using `BoxWithConstraints`.

```kotlin
BoxWithConstraints {
    val width = maxWidth / 3

    Row(modifier = Modifier.fillMaxWidth()) {
        Text(modifier = Modifier.width(width), text = "Currency")
        Text(modifier = Modifier.width(width), text = "Buy",  textAlign = TextAlign.Center)
        Text(modifier = Modifier.width(width), text = "Sell", textAlign = TextAlign.End)
    }

    LazyColumn {
        items(currencyList.size) { index ->
            CurrencyItem(index = index, width = width)
        }
    }
}
```

---

## Currency Data

```kotlin
data class Currency(
    val name: String,
    val buy: Float,
    val sell: Float,
    val icon: ImageVector
)

val currencyList = listOf(
    Currency("USD",   buy = 23.35f, sell = 23.10f, icon = Icons.Rounded.AttachMoney),
    Currency("YEN",   buy = 2.33f,  sell = 2.10f,  icon = Icons.Rounded.CurrencyYen),
    Currency("LIRA",  buy = 13.66f, sell = 13.30f, icon = Icons.Rounded.CurrencyLira),
    Currency("RUPEE", buy = 50.32f, sell = 49.98f, icon = Icons.Rounded.CurrencyRupee),
    Currency("RUBLE", buy = 34.40f, sell = 34.10f, icon = Icons.Rounded.CurrencyRuble),
)
```

---

## Getting Started

1. Clone the repository.
2. Open in **Android Studio Hedgehog** or later.
3. Sync Gradle and run on an emulator or physical device (API 26+).

---

## Dependencies

```kotlin
implementation(platform("androidx.compose:compose-bom:2024.xx.xx"))
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")
implementation("androidx.compose.material:material-icons-extended")
implementation("androidx.compose.animation:animation")
```
<img width="636" height="950" alt="image" src="https://github.com/user-attachments/assets/517bcb8e-2586-4dcc-8dee-06b54a777127" />

---

## License

For Education Purpose
