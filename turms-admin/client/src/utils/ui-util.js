export default class UiUtil {
    static fillSelectsWithValues(selectIds, values, actionGroups, filters) {
        // Update action groups
        for (const actionGroup of actionGroups) {
            for (const action of actionGroup) {
                if (action.fields) {
                    for (const field of action.fields) {
                        if (field.type.toUpperCase() === 'SELECT' && selectIds.includes(field.decorator[0])) {
                            if (!field.options) {
                                field.options = {};
                            }
                            field.options.values = values;
                        }
                    }
                }
            }
        }
        // Update filters
        if (filters) {
            for (const filter of filters) {
                if (filter.type.toUpperCase() === 'SELECT' && selectIds.includes(filter.name)) {
                    if (!filter.options) {
                        filter.options = {};
                    }
                    filter.options.values = values;
                }
            }
        }
    }
}