package com.tasty.recipesapp.adapter

class RecipeAdapter(private val dataSet: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recipeName: TextView
        val recipeDescription: TextView

        init {
            // Define click listener for the ViewHolder's View
            recipeName = view.findViewById(R.id.recipe_name)
            recipeDescription = view.findViewById(R.id.recipe_description)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.fragment_single_recipe, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.recipeName.text = dataSet[position].name
        viewHolder.recipeDescription.text = dataSet[position].description
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}